package SummedTests;

import SetUp.Scenario;
import EnterData.*;
import org.testng.annotations.Test;

public class EnterData extends Scenario {

    @Test(priority = 0)
    public void addNewProject() {
        System.out.println("Add new project");
        Test01_AddNewProject.newProjectShouldBeAdded();
    }

    @Test(priority = 1)
    public void addPartner() {
        System.out.println("Add seven partners");
        Test02_AddPartner.partnerShouldBeAdded();
    }

    @Test(priority = 2)
    public void addTasks() {
        System.out.println("Add 10 tasks");
        Test03_AddTasks.tasksShouldBeAdded();
    }

    @Test(priority = 3)
    public void addDeliverables() {
        System.out.println("Add 10 deliverables");
        Test04_AddDeliverable.deliverablesShouldBeAdded();
    }

    @Test(priority = 4)
    public void passAllGatesTillWP0() throws InterruptedException {
        System.out.println("Pass all gates till WP0");
        Test05_PassAllGatesTillWP0.callShouldBeClosed();
    }

    @Test(priority = 5)
    public void addPartnersInWP0stage() {
        System.out.println("Add 3 Partners in WP0 Stage");
        Test06_AddPartnersInWP0Stage.partnersShouldBeAdded();
    }

    @Test(priority = 6)
    public void addTasksInWP0stage() {
        System.out.println("Add 10 tasks in WP0 Stage");
        Test07_AddTasksInWP0Stage.tasksShouldBeAdded();
    }

    @Test(priority = 7)
    public void addDeliverablesInWP0stage() {
        System.out.println("Add 10 deliverables in WP0 Stage");
        Test08_AddDeliverableInWP0Stage.deliverablesShouldBeAdded();
    }

    @Test(priority = 8)
    public void passWP0gate() {
        System.out.println("Pass WP0 Gate");
        Test09_PassWp0Gate.wp0GateShouldBePassed();
    }

    @Test(priority = 9)
    public void addPartnersInPeStage() {
        System.out.println("Add 2 Partners in PE Stage");
        Test10_AddPartnersInPeStage.partnersShouldBeAdded();
    }

    @Test(priority = 10)
    public void addTasksInPeStage() {
        System.out.println("Add 10 Tasks in PE Stage");
        Test11_AddTaskaInPeStage.tasksShouldBeAdded();
    }

    @Test(priority = 11)
    public void addDeliverablesInPeStage() {
        System.out.println("Add 10 Deliverable in PE Stage");
        Test12_AddDeliverablesInPeStage.deliverablesShouldBeAdded();
    }
}
