# CS3343
CS3343 Group13
## Description
The system allows the employees of startups to book the rooms in the park in real-time, and view and modify their own bookings with easy to use commands.  In addition, the room management team can manage the system via Administrator account in order to improve the effectiveness of management, including the room booking, credit, companies, etc. Besides, the report function will generate the daily or monthly report to show the usage of rooms so that the management team can make the most of the resources.

## Requirements
JAVA JDK 11 or above is required.
Please download the JDK via https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html

## Usage
1. Download the release version of CRB_system.jar file
Open your Command Prompt (Windows) / MacOs(Terminal) and enter following command
```
java -jar CRB_system.jar
```

### Test Account
User Authentication is required. In addition, if the user is first time login need to reset the password.
```
Employee Account:
(Cmp1) Account 1:
Username: cp1test
Password: test

(Cmp1) Account 2:
Username: cp1test1
Password: test

Admin Account:
Username: admin
Password: admin
```


### Guide

#### Employee Function

#### Command List
```
rb = Room Booking
rbc = Cancel Booking
search = Search Booking
vra = View Room Available
own = Review Own Booking
logout = Logout
```

##### Room Booking
```
Command: rb
Please select month (Example: 2021-09/ 2021-09-26): _____ # booking date must be >= today
  S   M   T   W   T   F   S
          1*  2   3   4   5 
  6   7   8   9  10  11  12 
 13  14  15  16  17  18  19 
 20  21  22  23  24  25  26 
 27  28  29  30  31 
Please enter day: 1

It will show the avaiable room list here.
Please enter Room name: ____
Company Credit: 30.0
[0]: 9:30
[1]: 10:00
[2]: Exit
Please Enter the index you want to chose: 0		# select the start time
[0]: 10:00
[1]: Exit
Please Enter the index you want to chose: 0		# select the end time (it will show avaiable time only based on booking and company credit)

Booked by: cp1test
Room: 602
Start datetime: 2021-12-01T9:30
End datetime: 2021-12-01T10:00
```

##### Cancel Booking
```
Command: rbc
Please you want to cancel date: ________ (date format is yyyy-mm-dd)
Booked by: cp1test
Room: 602
Start datetime: 2021-12-01T9:30
End datetime: 2021-12-01T10:00

Confirm[Y/n]: __
Room booking cancel
Company Credit update: 30.0

```

##### Search Booking

```
Command: search
# It will enter to search mode
[date| emp | room] [date/name] [ASC|DESC (optional)]
Enter: exit will quit the search mode.

Search: _________

Example:
date 2021-12-01 
emp cp1test
room 602 DESC

```

##### View Room Available
```
Command: vra
Please select month (Example: 2021-09/ 2021-09-26): ______
  S   M   T   W   T   F   S
          1   2   3   4   5 
  6   7   8   9  10  11  12 
 13  14  15  16  17  18  19 
 20  21  22  23  24  25  26 
 27  28  29  30 
Please enter day: __
# It will show the avaiable room list here.
```


##### Review Own Booking
```
Command: own
Booked by: cp1test
Room: 602
Start datetime: 2021-12-01T9:30
End datetime: 2021-12-01T10:00
```

#### Admin Function
##### Command List
```
rr = Remove Room
cc = Company Create
vra = View Room Available
uc = Create Employee
cr = Remove Company
ar = Add Room
rbc = Cancel Booking
search = Search Booking
upwdrest = User Password Reset
rep = Report
credit = Extra Credit
ur = Lock User
logout = Logout
```

##### Remove Room
```
Command: rr
Enter Roomname: ___
Confirm[Y/n]: Y
Removed {number} Room Booking
```

##### Company Create
```
Command: cc
Please enter the Company name: cmp_name
cmp_name is created.
```

##### Create Employee
```
Command: uc
Search Company Name: c
[0]: cmp1
[1]: cmp2
[2]: cmp3
[3]: cmp4
[4]: Exit
Please Enter the index you want to chose: __
Username: new_user
new_user is created, init password: (,s6W=J?
User need to reset password in login first time.
```

##### Remove Company
```
Command: cr
Search Company Name: cmp
[0]: cmp1
[1]: cmp2
[2]: cmp3
[3]: cmp4
[4]: Exit
Please Enter the index you want to chose: __
Confirm[Y/n]: Y
Company Removed.
```

##### User Password Reset
```
Command: upwdrest
Enter Employee username: _______
Please mark the new password: {Random_pwd}
You needs to reset password in first time login.
```

##### Report
```
[cmp | room ] [name] [year-month]
[date] [year-month-date]

Search: _____________

Example:
cmp cmp1 2021-12
room 602 2020-09
date 2021-12-01
```

##### Extra Credit
*Credit will automaticly renew weekly.
```
Command: credit
Search Company Name: c
[0]: cmp1
[1]: cmp2
[2]: cmp3
[3]: Exit
Please Enter the index you want to chose: 0
Please enter extra credit (hours): ___
cmp1 Credit updated.
```

##### Lock User
```
Command: ur
Enter Employee username: _______
User locked.
```