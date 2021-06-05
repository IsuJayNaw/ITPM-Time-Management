create database itpm_timeTable;

use itpm_timeTable;

create table employee (
	employeeID varchar(15),
    employeeName varchar(25),
    startDate varchar(25),
    endDate varchar(25),
    workingDays varchar(5),
    workingHours varchar(5)
);

create table lecture(
	lecture varchar(20),
    ssid varchar(20),
    stdGroup varchar(20),
    timePeriod varchar(20),
    subGroup varchar(20)
);

create table Location(
	room varchar(10),
    selectDay varchar(20),
    startTime varchar(15),
    endTime varchar(15)
);

select * from employee;
select * from lecture;
select * from Location;