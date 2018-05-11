# kapsh_http_server_mockup
Mein Team ist in der Kapsch TrafficCom für die technische Integration der Systemkomponenten zur Gesamtlösung verantwortlich.
Dabei verwenden wir mitunter ein für unsere Zwecke angepasstes Testframework basierend auf dem Robot-Framework 
(http://robotframework.org).
Die darin verwendeten Libraries sind in Python geschrieben.
Um Tests mit externen Schnittstellen durchführen zu können, es immer wieder notwendig Mockups zu erstellen.
Im gestellten Beispiel wird zum Testen einer HTTP Schnittstelle ein HTTP Server Mockup benötigt.
Daher hätten wir uns jetzt auch ein Beispiel überlegt, 
in dem zum Testen einer HTTP Schnittstelle ein HTTP Server Mockup benötigt wird.
Die Sprache, in der der Mockup realisiert wird, überlassen wir Ihnen.
Bevorzugt von unserer Seite wäre natürlich Python ≥ 2.7. 
Wir schätzen den Aufwand für dieses Beispiel
bei einem Entwickler mit entsprechenden Python Kenntnissen auf ungefähr 2 Stunden.
Bei nur grundlegenden Python-Kenntnissen schätzen wir den Aufwand auf ungefähr 8 Stunden.  

# Beispiel: 
Der HTTP Mockup Server wird über die Command Line gestartet und akzeptiert folgende Parameter:
  -p|--port: der Port auf dem der Server hören soll
  
 # BEISPIEL:
 <exe> -p 1234   #startet den Server(<exe>) auf Port 1234 
 
 Der HTTP Server implementiert folgende HTTP Aufrufe: 
     SET RESPONSE: URI Path: /set_response 
     
     HTTP Methode: GET
     
     Sendet dem Server eine HTTP Server MockUp Antwort, die der Server bei der nächsten Anfrage 
     auf den angegebenen Parameter path zurück sendet.                  
     
     Query Parameter:                                             
     
     path (str):  URI path auf welchen diese Antwort gesendet werden soll 
     state (int): Optional - HTTP Status der bei der nächsten Anfrage auf path zurückgesendet werden soll. 
                  Wenn kein state übergeben wird sollte 200 als default Wert zurückgegeben werden.
     content (str): Optional - Die Daten die auf die Anfrage auf path zurückgesendet werden sollen.   
     
     Antwort:                                              
     HTTP Status 200: Die Antwort wurde gespeichert                                              
     HTTP Status 400: Der Parameter path wurde nicht gesetzt, Antwort wurde nicht gespeichert   
     
     MOCK RESPONSE:          
     
     URI Path: /&lt;path>     
     HTTP Methode: GET|POST
     Anfrage auf einen beliebigen Pfad mit beliebigen Query Parametern
     Antwort:
     HTTP Status 404: wenn keine Antwort für diese Anfrage gespeichert wurde
     Wurde eine Antwort durch /set_response abgespeichert, wird der state und der content dieser gespeicherten Antwort
     zurück gesendet.
     
     PROTOCOL
     URI Path: /protocol
     HTTP Methode: GET 
     
     Der Server liefert das Kommunikationsprotokoll als JSON Objekt zurück.
     Anfrage an /protocol und /set_response werden nicht gelistet   
     Keine Query Parameter
     
     Antwort:
     HTTP Status 200: Das Protokoll als JSON Objekt
     [{"request":{"path": : <Der URI Pfad der Anfrage>,
     "timestamp": <Zeitstempel der Anfrage>, 
     "parameters"<Die Query Parameter der Anfrage>},
     "response":{"state": &lt;HTTP Status der Antwort>,
     "content": <Der Daten der Antwort>}},
     {...},]
     
     # BEISPIEL:
     Request: GET localhost:1234/set_response?path=/greet/de&amp&content=hallo
     Response: 200 
     Request: GET localhost:1234/set_response?path=/greet/it&amp&content=ciao
     Response: 200 
     Request: GET localhost:1234/set_response?path=/greet/foo&amp&state=500
     Response: 200
     Request: GET localhost:1234/greet/de?key=value
     Response: 200:hallo
     Request: GET localhost:1234/greet/foo 
     Response: 500 
     Request: GET localhost:1234/greet/xxx 
     Response: 404
     Request: GET localhost:1234/protocol
     Response: 200
     
     :[{"request":{"path": "greet/de","timestamp": 1480590417312,"parameters" : {"key":"value"}},
        "response":{"state": 200,"content": "hallo"},},
        {"request":{"path": "greet/foo","timestamp": 1480590427312,"parameters" : ""},
        "response":{"state": 500,"content": ""},},
        {"request":{"path": "greet/xxx","timestamp": 1480590427512,"parameters" : ""},
        "response":{"state": 404,"content": ""},},]
     
     * Weiters bei uns im Team verwendete Frameworks, Programmiersprachen und Tools: html, css,
     JavaScript, Django, Robot Framework, Python, C#, SQL, SOAP, REST, Selenium, Ranorex, Soap UI  
    
