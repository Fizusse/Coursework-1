
package dt.mycours;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
    

class Participant {
    private String name;
    private int swimmingTime, cyclingTime, runningTime;

    public Participant(String name, int swimmingTime, int cyclingTime, int runningTime) {
        this.name = name;
        this.swimmingTime = validTime(swimmingTime);
        this.cyclingTime = validTime(cyclingTime);
        this.runningTime = validTime(runningTime);
    }

    private int validTime(int time) {
        if (time < 0) throw new IllegalArgumentException("Time cannot be zero.");
        return time;
    }

    public int getTotalTime() {
        return swimmingTime + cyclingTime + runningTime;
    }

    public void displayDetails() {
        System.out.println(name + ": Total Time = " + getTotalTime() + " minutes");
    }
}

class EliteParticipant extends Participant {
    private String sponsor;

    public EliteParticipant(String name, int swimmingTime, int cyclingTime, int runningTime, String sponsor) {
        super(name, swimmingTime, cyclingTime, runningTime);
        this.sponsor = sponsor;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Sponsor: " + sponsor);
    }
}

public class TriathlonResults {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant("Alice", 25, 40, 20));
        participants.add(new EliteParticipant("Bob", 20, 35, 25, "FitnessPro"));
        participants.add(new Participant("Charlie", 30, 50, 30));
        participants.add(new Participant("Diana", 28, 42, 18));

        participants.sort(Comparator.comparingInt(Participant::getTotalTime));

        System.out.println("Results:");
        participants.forEach(Participant::displayDetails);

        System.out.println("\nFastest: ");
        participants.get(0).displayDetails();
        if (participants.size() > 1) {
            System.out.println("\nSecond Fastest: ");
            participants.get(1).displayDetails();
        }
    }
}
