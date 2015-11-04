package com.udacity.gradle.builditbigger.jokes;

import java.util.Random;
import java.util.logging.Logger;

import sun.rmi.runtime.Log;

public class Joker {
    private static final String[] mJokes = new String[] {
            "What's the difference between Windows 95 and a virus? A virus does something.",
            "Redmond, WA --Microsoft announced today that the official release date for the new operating system \"Windows 2000\" " +
                    "will be delayed until the second quarter of 1901.",
            "What do computers eat when they get hungry? Chips.",
            "What's the difference between Windows 95 and a virus? A virus does something.",
            "If Bill Gates had a dime for every time a Windows box crashed...Oh, wait a minute, he already does.",
            "Q: How many Bill Gateses does it take to change a light bulb? A: One. He puts the bulb in and lets the world revolve around him.",
            "My computer made a funny sound the other day. Of course, I've never heard it get thrown out a window before.",
            "Q. What creature has the best aptitude for engineering? A. The spider -- It has its own website.",
            "Q: What's the best way to accelerate a Mac? A: 9.81 m/s2",
            "Customer: \"I'm running Windows '95.\" Tech: \"Yes.\" Customer: \"My computer isn't working now.\" Tech: \"Yes, you said that.\"",
            "Q: What is the difference between Windows 95 and Windows 98? A: 3 years",
            "Q: How does Bill Gates screw in a light bulb? A: He doesn't. He declares darkness the industry standard.",
            "Q: What does a proud computer call his little son? A: A microchip off the old block.",
            "Q: What happens if you cross a midget and a computer? A: You get a short circut.",
            "Why did the school bully kick the classroom computer? Someone told him he was supposed to boot up the system.",
            "The Three Laws of Secure Computing: 1) Don't buy a computer. 2) If you do buy a computer, don't plug it in. 3) If you do plug " +
                    "it in, sell it and return to step 1.",
            "Computers manufacturer is considering changing the command \"Press Any Key\" to \"Press Return Key\" because of the " +
                    "flood of calls asking where the \"Any\" key is.",
            "Technical support had a caller complaining that her mouse was hard to control with the dust cover on. The cover " +
                    "turned out to be the plastic bag the mouse was packaged in.",
            "A customer was asked to send a copy of her defective diskettes to the technician. A few days later a letter arrived " +
                    "from the customer along with Xeroxed copies of her diskettes.",
            "Customer: \"How do I print my voicemail?\"",
            "Q: What do you get when you cross a Pentium PC with a research grant? A: A mad scientist.",
            "Q: What's another name for the \"Intel Inside\" sticker they put on Pentiums? A: The warning label.",
            "Q: What do you call a series of FDIV instructions on a Pentium? A: Successive approximations.",
            "Q: Complete the following word analogy: Add is to Subtract as Multiply is to: 1) Divide 2) ROUND 3) RANDOM 4) On a " +
                    "Pentium, all of the above A: Number 4.",
            "Q: What algorithm did Intel use in the Pentium's floating point divider? A: \"Life is like a box of chocolates...\" " +
                    "(Source: F. Gump of Intel)",
            "Q: Why didn't Intel call the Pentium the 586? A: Because they added 486 and 100 on the first Pentium and got 585.999983605.",
            "What is an astronaut's favorite key on a computer keyboard? The space bar.",
            "What happened when the computer fell on the floor? It slipped a disk.",
            "Why was there a bug in the computer? It was looking for a byte to eat.",
            "What is a computer virus? A terminal illness.",
            "To err is human; but to really mess things up requires a computer.",
            "Computers are not intelligent. They only think they are.",
            "Computers make very fast, very accurate mistakes.",
            "My computer isn't that nervous. It's just a bit ANSI.",
            "The attention span of a computer is as long as its electrical cord.",
            "Why do programmers always get Christmas and Halloween mixed up? Because DEC 25 = OCT 31",
            "How do you keep a programmer in the shower all day? Give him a bottle of shampoo which says \"lather, rinse, repeat.\"",
            "Why all Pascal programmers ask to live in Atlantis? Because it is below C level.",
            "How many Java programmers does it take to change a light bulb? One, to generate a \"ChangeLightBulb\" event to the socket.",
            "What did one keyboard say to the other keyboard? Sorry, you're not my type.",
            "What did one mouse say to the other mouse? I get a click out of you.",
            "What did the mouse say to the webcam? Cheese.",
            "What do computer experts do at weekends? Go for a disk drive.",
            "What do you do if your computer hums? Tell it to change its socsks!",
            "What do you get if you cross a computer with a ballet dancer? The Netcracker suite.",
            "What do you get if you cross a computer with a hamburger? A big mac.",
            "What do you get if you stuff your computer's disk drive with herbs? A thyme machine.",
            "What do you get if you take your computer to an ice rink? A slipped disk.",
            "What's the difference between your finger and a hammer? I don't know!Well, you're not using my computer keyboard then!",
            "When do computers go to sleep? When it's internight.",
            "Where does an elephant carry its laptop? In its trunk.",
            "Where is the best place to buy computer software? Washington C.D",
            "Which football team to you need to connect up your computer? Leeds.",
            "Which kind of ink do you put in your computer's printer? Black, Red or Iced? Iced Ink? Well, yes you do, but I didn't " +
                    "want to mention it.",
            "How do you find white shirts on the Internet? Use a starch engine.",
            "How does the vicar explore the Internet? With the church mouse."
    };

    public String tellRandomJoke() {
        // Generate a random number based on the size of the joke array
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(mJokes.length + 1);

        // Return the random joke
        return mJokes[random];
    }
}
