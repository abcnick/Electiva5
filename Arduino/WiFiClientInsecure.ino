#include <WiFiClientSecure.h>

const char* ssid     = "FAMILIA LOPEZ";     // your network SSID (name of wifi network)
const char* password = "1014227004#MFC"; // your network password
const char* server = "electivav-nicolasg.000webhostapp.com";  // Server URL
unsigned int*  resetCnt = 0;  // 


WiFiClientSecure client;

void (* resetFunc) (void) = 0;
void parpadeo() {
  digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
  digitalWrite(27, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1000);                       // wait for a second
  digitalWrite(LED_BUILTIN, LOW);    // turn the LED off by making the voltage LOW
  digitalWrite(27, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(1000);                       // wait for a second
}


void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(27, OUTPUT);
  pinMode(26, OUTPUT);
  
  //Initialize serial and wait for port to open:
  Serial.begin(115200);
  delay(100);

  Serial.print("Attempting to connect to SSID: ");
  Serial.println(ssid);
  WiFi.begin(ssid, password);

  // attempt to connect to Wifi network:
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    // wait 1 second for re-trying
    delay(1000);
  }

  Serial.print("Connected to ");
  Serial.println(ssid);
  
  Serial.println("");
  Serial.println("WiFi connected");

  Serial.println("\nStarting connection to server...");
  client.setInsecure();//skip verification
  if (!client.connect(server, 443))
    Serial.println("Connection failed!");
  else {
    
    Serial.println("Connected to server!");
    // Make a HTTP request:
    client.println("GET https://electivav-nicolasg.000webhostapp.com/led/logic.php?actuadorId=1 HTTP/1.0");
    client.println("Host: electivav-nicolasg.000webhostapp.com");
    client.println("Connection: close");
    client.println();

    while (client.connected()) {
      String line = client.readStringUntil('\n');
      if (line == "\r") {
        Serial.println("headers received");
        break;
      }
    }
    // if there are incoming bytes available
    // from the server, read them and print them:
    char commando [10];
    int i = 0;
    while (client.available()) {
      char c = client.read();
      resetCnt = 0 ;

      if (commando[1] == '_' && i < 4){
        commando [i] = c;
        i++;
       }
       
      if (c == '_' && i < 2){
        commando [i] = c;
        i++;
       }
      
      Serial.write(c);
    }
    Serial.println(commando);
    if (commando[2] == 'e' ){
      digitalWrite(LED_BUILTIN, HIGH);   // turn the LED on (HIGH is the voltage level)
      digitalWrite(26, HIGH);   // turn the LED on (HIGH is the voltage level)
      digitalWrite(27, HIGH);   // turn the LED on (HIGH is the voltage level)
      Serial.println("Led encendido");
      resetCnt = 0;
    }
    if (commando[2] == 'a' ){
      digitalWrite(LED_BUILTIN, LOW);   // turn the LED on (HIGH is the voltage level)
      digitalWrite(26, LOW);   // turn the LED on (HIGH is the voltage level)
      digitalWrite(27, LOW);   // turn the LED on (HIGH is the voltage level)
      Serial.println("Led Apagado");
      resetCnt = 0;
    }
    resetCnt++;
    delay(2000);
    
    if ((int)resetCnt >= 30){
       resetCnt = 0;
       resetFunc();  
    }    
    
    client.stop();
  }
  resetCnt++;
  delay(2000);
  if ((int)resetCnt >= 30){
    resetCnt = 0;
    resetFunc();  
  }
 }

void loop() {
  // do nothing
}
