#include <WiFi.h>
#include <OneWire.h>
#include <DallasTemperature.h>

// wifi information
const char* ssid = "It hurts when IP 2.4";
const char* password = "youshallnotpassword";

// global values
float temperature;
int moistureValueRaw;
int moistureValuePercent;

bool debug = true;

#define ONE_WIRE_BUS 18
#define SOIL_MOISTURE_PIN 35
#define LED 19

OneWire oneWire(ONE_WIRE_BUS);
DallasTemperature sensors(&oneWire);

void setup() {
  Serial.begin(115200);
  sensors.begin();

  pinMode(SOIL_MOISTURE_PIN, INPUT);
  pinMode(LED, OUTPUT);
  connectWiFi();
  delay(10);

  // print wifi debug
  Serial.println("\nWLAN verbunden");
  Serial.print("IP-Adresse: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  digitalWrite(LED, HIGH);

  readMoistureSensorData();
  readTemperatureSensorData();
  digitalWrite(LED, LOW);

  if (debug) {
    printDebug();
  }
  delay(15000); // wait 15 seconds
}

void connectWiFi() {
  Serial.print("\nVerbinde mit ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);
}

void readTemperatureSensorData() {
  sensors.requestTemperatures();
  temperature = sensors.getTempCByIndex(0);
}

void readMoistureSensorData() {
  moistureValueRaw = analogRead(SOIL_MOISTURE_PIN);
  moistureValuePercent = map(moistureValueRaw, 0, 4095, 0, 100);
}

void printDebug() {
  // print temperature debug
  Serial.printf("Temperature: %.2f °C\n", temperature);

  // print moisture sensor debug
  Serial.print("Analog Value: ");
  Serial.print(moistureValueRaw);
  Serial.print(" | Soil Moisture: ");
  Serial.print(moistureValuePercent);
  Serial.println("%");
}