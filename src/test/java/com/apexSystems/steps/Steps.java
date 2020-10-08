package com.apexSystems.steps;

import com.apexSystems.pojo.Puppy;
import com.apexSystems.sites.PuppySite;
import com.apexSystems.utils.Utils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.apexSystems.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Steps {
    private PuppySite puppySite;
    List<Puppy> puppyCart, puppyCandidates;

    public Steps(Hooks h) {
        this.puppySite = h.getPuppySite();
        puppyCandidates = new ArrayList<Puppy>();
        puppyCart = new ArrayList<Puppy>();
    }

    @Given("I have navigated to Home Page")
    public void iHaveNavigatedToHomePage() {
        puppySite.home().goTo(Constants.URL);
        assertTrue(
                "User can't see the puppy page",
                puppySite.home().isAt()
        );
    }

    @When("I select {word}")
    public void iSelectAdoptBrook(String puppyName) {

        //selects a puppy from the home page by the puppyName and gets its info
        Puppy adopted = puppySite.home().selectPuppyByName(puppyName);

        //makes sure the names coincide
        assertTrue("Puppy " + puppyName + " was selected succesfully",
                adopted.getName().equals(puppyName)
        );

        puppyCandidates.add(adopted);
    }

    @And("I add {word} to cart")
    public void addPuppyToCart(String puppyName) {
        //asserts we're at the puppyDetails page
        assertTrue("We can't see puppyInfo",
                puppySite.puppyDetails().isAt()
        );
        //gets info from the puppyDetails page
        Puppy puppyDetails = puppySite.puppyDetails().getPuppyInfo();
        Puppy currentPuppy = Utils.findPuppy(puppyCandidates, puppyName);
        //makes sure the basic info coincides (name, sex, breed and photo)
        assertTrue(
                "Puppy info does not coincide",
                currentPuppy.basicInfoEquals(puppyDetails)
        );

        puppyCart.add(puppyDetails);

        puppySite.puppyDetails().adoptPuppy();
    }

    @And("I complete the adoption")
    public void iCompleteTheAdoption() {
        //checks the Cart page is visible
        assertTrue(
                "We did not reach the Cart Page",
                puppySite.cart().isAt()
        );

        //get the puppies currently in the cart
        List<Puppy> puppiesInCart = puppySite.cart().getPuppiesInCart();

        //make sure puppies already in the cart are the same as those in the page.
        for(Puppy p: puppiesInCart) {

            assertTrue(
                    "Puppy info does not coincide",
                    Utils.isPuppyInList(puppyCart, p)
            );

        }

        //complete the adoption
        puppySite.cart().completeAdoption();
    }

    @And("I place order with {string}")
    public void iPlaceOrderWith(String payType) {
        //checks the details page is visible
        assertTrue(
                "We did not reach the Cart Page",
                puppySite.details().isAt()
        );

        puppySite.details().placeOrder(payType);
    }

    @Then("I should see an adoption confirmation message")
    public void iShouldSeeAnAdoptionConfirmationMessage() {
        //checks the Home page is visible
        assertTrue(
                "We did not reach the Cart Page",
                puppySite.home().isAt()
        );

        String message = puppySite.home().getWelcomeMessage();
        //check the message
        assertTrue(
                "Thank you message is not correct.",
                message.equals(Constants.THANK_YOU_MESSAGE)
        );
    }
}
