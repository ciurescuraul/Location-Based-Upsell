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