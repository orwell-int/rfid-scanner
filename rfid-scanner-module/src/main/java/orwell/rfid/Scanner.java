package orwell.rfid;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.addon.RFIDSensor;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by parapampa on 14/06/15.
 */
public class Scanner {
    private static final String RFID_EMPTY_VALUE = "0";
    private static final String VALUE_SEPARATOR = " ";
    private RFIDSensor rfidSensor;
    private static String FILENAME = "rfidlog.dat";


    public Scanner(SensorPort sensorPort) {
        this.rfidSensor = new RFIDSensor(sensorPort);
    }

    private FileOutputStream createFileOutputStream() {
        FileOutputStream out = null; // declare outside the try block
        File data = new File(FILENAME);

        try {
            out = new FileOutputStream(data);
        } catch(IOException e) {
            System.err.println("Failed to create output stream");
            System.exit(1);
        }
        return out;
    }

    public void run() {
        FileOutputStream fileOutputStream = createFileOutputStream();
        DataOutputStream dataOut = new DataOutputStream(fileOutputStream);

        Sound.beepSequenceUp();
        String rfidValueCurrent;

        while (!Button.ESCAPE.isDown()) {
            rfidValueCurrent = Long.toString(rfidSensor.readTransponderAsLong(true));

            LCD.clear(4);
            LCD.clear(5);
            LCD.drawString(rfidValueCurrent, 0, 4, false);
            LCD.drawString(Integer.toString(rfidSensor.getStatus()), 0, 5, false);

            if (!rfidValueCurrent.equals(RFID_EMPTY_VALUE)) {
                try {
                    dataOut.writeBytes(rfidValueCurrent);
                    dataOut.writeBytes(VALUE_SEPARATOR);
                    Sound.beep();
                } catch (IOException e) {
                    System.err.println("Failed to write to output stream");
                    Sound.buzz();
                }
            }
        }
        try {
            dataOut.close();
        } catch (IOException e) {
            System.err.println("Failed to close output stream");
            Sound.buzz();
        }
        Sound.beepSequence();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(SensorPort.S2);
        scanner.run();

    }
}
