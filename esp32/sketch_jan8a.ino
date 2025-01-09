#include <WiFi.h>
#include <OneWire.h>
#include <DallasTemperature.h>


const char* ssid = "It hurts when IP 2.4";
const char* password = "youshallnotpassword";

#define ONE_WIRE_BUS 18

OneWire oneWire(ONE_WIRE_BUS);
DallasTemperature sensors(&oneWire);

void setup() {
  Serial.begin(115200);
  sensors.begin();
  delay(10);


  // Verbinden mit dem WLAN
  Serial.println();
  Serial.print("Verbinde mit ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WLAN verbunden");
  Serial.print("IP-Adresse: ");
  Serial.println(WiFi.localIP());

  DeviceAddress sensorAddress;
if (sensors.getAddress(sensorAddress, 0)) {
    Serial.print("Sensor-Adresse: ");
    for (uint8_t i = 0; i < 8; i++) {
        Serial.print(sensorAddress[i], HEX);
    }
    Serial.println();
} else {
    Serial.println("Sensoradresse nicht gefunden.");
}

  Serial.print("Gefundene Sensoren: ");
  Serial.println(sensors.getDeviceCount());
}

void loop() {
  sensors.requestTemperatures(); // Fordert eine Messung an
  delay(750);
  float temperature = sensors.getTempCByIndex(0); // Temperatur in °C lesen
  Serial.print("Temperatur: ");
  Serial.print(temperature);
  Serial.println(" °C");
  delay(1000); // 1 Sekunde warten
}