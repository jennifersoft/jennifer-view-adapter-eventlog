## Getting started

Execute the following in the Jennifer management screen.

 1. Extension & Notice> Adapter and Plugin
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

If there is no option, the default value of the table is applied. Here's how to add an option:

