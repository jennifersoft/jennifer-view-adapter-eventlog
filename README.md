## Getting started

Execute the following in the Jennifer management screen.

 1. Extension & Notice > Adapter and Plugin
 2. Click the Add button.
 3. Select the 'EVENT' type.
 4. Enter the 'eventlog' ID.
 5. Enter the adapter path directly or upload the file.
 6. Enter the class 'event.LogAdapter'.

## How to use Options

Adapter options are shown in the table below.

| Key           | Default Value |
| ------------- |:-------------:|
| pattern       | [%time] domain=%domainName(%domainId), instance=%instanceName(%instanceId), level=%eventLevel, name=%eventName, value=%value |
| date_format   | yyyy-MM-dd HH:mm:ss |
| full_path | ../logs/eventlog.%d{yyyy-MM-dd}.log |
| rolling_mode | true |

If there is no option, the default value of the table is applied. Here's how to add an option:

<img width="887" alt="custom_key" src="https://user-images.githubusercontent.com/1277117/26880960-ff4ef69c-4bd0-11e7-93b6-185391351711.png">

<img width="887" alt="custom_key2" src="https://user-images.githubusercontent.com/1277117/26881100-66ae4298-4bd1-11e7-886b-851f4441fd0c.png">
