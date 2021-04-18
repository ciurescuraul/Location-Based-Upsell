# Location-Based Upsell
## High Level Design - Aprilie / 2021

## Agenda
- Overview
- Arhitecture
- FileProcessor
- EventProcessor
- Sms-Gateway
- Sms-Gateway-Simulator
- Exercise Scope

# Overview
- Target a subscriber with a promotional SMS based on his location
    - Airport -> "You may purchase this roaming package"
    - Concert -> "Visit Orange stand to get a free 100GB Voucher"
    
- Location is determined following a Voice Call
    - Call -> MSC -> CDR File (call detail record)
    - CDR: 
        - A-Number
        - B-Number
        - Call start time
        - Call duration
        - Cell ID
        - ... etc
    - Interest Area - one or more Cell ID's
    - Additional subscriber information may be needed
        - Do not send a message for roaming package if subscriber already has the package assigned

![alt text](https://github.com/ciurescuraul/location-based-upsell/blob/943e828ffb74dd8d4fbee31b60acc80fc6df30d6/HLD.png)

# FileProcessor
- Spring Boot Application
- Input
    - CDR files (*.cdr text files)
    
- Output
    - JMS entries in Queue
    - Statistics about processed files in DB
        - File name
        - Header/Trailer present
        - Total number of records processed
        - Records successfully processed
        - Records with errors (not enqueued)
    - Once a file is processed, it is renamed with a ".done" extension
    - Error records are copied into a ".error" file
    
- Configuration
    - DB Connection
    - JMS Queue
    - Input Directory
    - Input file extension
    
- Logic 
    - Pick the oldest files from input directory
    - Read the file line by line
    - Decode each line into a record and validate required fields
    - Create and enqueue a JSON object into the JMSQueue
    
# Generic Input File Format
![alt text](https://github.com/ciurescuraul/location-based-upsell/blob/944f9b997578742a54205e5c712d222e4246564b/input-file-format.png)

# EventProcessor
- Spring Boot Application
- Input
    - JMS entries in Queue
    
- Output
    - SMS-es
    
- Configuration
    - JMS Queue
    - DB connection
    - SMS-Gateway: url, username, password
    
- Logic
    - A dispatcher module reads the records from JMS Queue one-by-one
    - Based on ClientId, it calls the plugin
    - The plugin:
        - Will determine if the call was done from an Interest Area 
            - Check Cell-Id in DB
        - Will determine what type of campaign applies in that specific Interest Area (e.g. Concert or Airport)
        - For 'concert' campaign type, grab the message content from DB and directly send the SMS
        - For 'airport' campaign type, we do one more query in DB to determine if subscriber has roaming offer or not. If he does not have the roaming offer, then we send an SMS with the upsell atempt (e.g. "For 4 EUR, you may purchase a roaming package" ).
    
![alt_text](https://github.com/ciurescuraul/location-based-upsell/blob/43c5649ae89dbbc180b4719fbe2743367bdbed2f/no-campaign-diagram.png)

![alt_text](https://github.com/ciurescuraul/location-based-upsell/blob/37362d4e91acfc99f119a882fd99d73667703ee7/concert-campaign-diagram.png)

![alt_text](https://github.com/ciurescuraul/location-based-upsell/blob/37362d4e91acfc99f119a882fd99d73667703ee7/airport-campaign-diagram.png)