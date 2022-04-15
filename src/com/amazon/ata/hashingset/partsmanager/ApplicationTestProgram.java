package com.amazon.ata.hashingset.partsmanager;

import java.util.Arrays;

public class ApplicationTestProgram {

        public static void main(String[] args) {
                System.out.println("-".repeat(50) + "\nDefining flex part...");
                DevicePart flex = new DevicePart("Knowles", "KAS-700-0147",
                        Arrays.asList(AmazonDevice.FIRE_TV_STICK, AmazonDevice.FIRE_TV_STICK_4K, AmazonDevice.ECHO_BUDS));
                System.out.println(flex.hashCode()); 

                System.out.print("-".repeat(50) + "\nDefining button part...");
                DevicePart button = new DevicePart("CUI Devices", "CMEJ-04150420P",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(button.hashCode()); 

                System.out.print("-".repeat(50) + "\nDefining omnidirectional part...");
                DevicePart omnidirectional = new DevicePart("Knowles", "FG-23329-P142",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(omnidirectional.hashCode());

                System.out.print("-".repeat(50) + "\nDefining noiseCancelling part...");
                DevicePart noiseCancelling = new DevicePart("Knowles", "FB-EM-30342-000",
                        Arrays.asList(AmazonDevice.ECHO_BUDS));
                System.out.println(noiseCancelling.hashCode()); 

                System.out.print("-".repeat(50) + "\nDefining cuiDevice part...");
                DevicePart cuiDevice = new DevicePart("CUI Devices", "CMEJ-04150420P",
                        Arrays.asList(AmazonDevice.ECHO_PLUS));
                System.out.println(cuiDevice.hashCode()); 

                System.out.print("-".repeat(50) + "\nDefining Wired part...");
                DevicePart wired = new DevicePart("Knowles", "VFG-30747-000",
                        Arrays.asList(AmazonDevice.FIRE_7_KIDS_EDITION, AmazonDevice.FIRE_HD_8_KIDS_EDITION, AmazonDevice.FIRE_HD_10_KIDS_EDITION));
                System.out.println(wired.hashCode()); 

                System.out.println("-".repeat(50) + "\nDefining cord part...");
                DevicePart cord = new DevicePart("CUI Devices", "CMEJ-4622-25-L082",
                        Arrays.asList(AmazonDevice.ECHO));
                System.out.println(cord.hashCode()); 

                System.out.println("-".repeat(50) + "\nDefining grounded part...");
                DevicePart grounded = new DevicePart("Knowles", "EK-26899-P03",
                        Arrays.asList(AmazonDevice.ECHO_FRAMES));
                System.out.println(grounded.hashCode()); 

                System.out.println("-".repeat(50) + "\nDefining puiAudio part...");
                DevicePart puiAudio = new DevicePart("PUI Audio", "AMM-2738B-R",
                        Arrays.asList(AmazonDevice.ECHO_DOT, AmazonDevice.ECHO_SHOW_5, AmazonDevice.ECHO_SHOW_8));
                System.out.println(puiAudio.hashCode()); 

                PartManager microphonePartManager = new PartManager();

                System.out.println("-".repeat(50) + "\nadding flex part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(flex);

                System.out.println("-".repeat(50) + "\nadding button part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(button);

                System.out.println("-".repeat(50) + "\nadding omnidirectional part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(omnidirectional);

                System.out.println("-".repeat(50) + "\nadding noiseCancelling part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(noiseCancelling);

                System.out.println("-".repeat(50) + "\nadding cuiDevice part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(cuiDevice);

                System.out.println("-".repeat(50) + "\nadding wired part to HashSet in PartManager...");
                microphonePartManager.addDevicePart(wired);

                return;
        }
}
