/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface;

/**
 *
 * @author Anojan
 */
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.fazecast.jSerialComm.SerialPortEventListener;

import java.io.IOException;
import java.io.InputStream;

public class RFIDReader extends SerialPortEventListener {
    private SerialPort serialPort;

    public void initialize() {
        serialPort = SerialPort.getCommPort("COM3"); // Change to your port name
        serialPort.setBaudRate(9600);
        serialPort.addDataListener((SerialPortDataListener) this);

        if (serialPort.openPort()) {
            System.out.println("Serial port opened successfully.");
        } else {
            System.err.println("Error opening serial port.");
        }
    }

    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
            byte[] newData = new byte[serialPort.bytesAvailable()];
            int numRead = serialPort.readBytes(newData, newData.length);

            String rfidData = new String(newData, 0, numRead);
            System.out.println("RFID Data Received: " + rfidData);

            // TODO: Process the received RFID data and perform login/authentication
        }
    }

    public static void main(String[] args) {
        RFIDReader rfidReader = new RFIDReader();
        rfidReader.initialize();

        // Keep the program running to continue listening for RFID data
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            System.err.println(e.toString());
        }
    }
}

