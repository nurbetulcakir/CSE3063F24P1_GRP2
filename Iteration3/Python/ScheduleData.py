from enum import Enum


class ScheduleData:


    class Day(Enum):
        MONDAY = "Monday"
        TUESDAY = "Tuesday"
        WEDNESDAY = "Wednesday"
        THURSDAY = "Thursday"
        FRIDAY = "Friday"

    class StartTime(Enum):
        T0830 = "08:30"
        T0930 = "09:30"
        T1030 = "10:30"
        T1130 = "11:30"
        T1300 = "13:00"
        T1400 = "14:00"
        T1500 = "15:00"
        T1600 = "16:00"

    class EndTime(Enum):
        T0920 = "09:20"
        T1020 = "10:20"
        T1120 = "11:20"
        T1220 = "12:20"
        T1350 = "13:50"
        T1450 = "14:50"
        T1550 = "15:50"
        T1650 = "16:50"

    class Classroom(Enum):
        M1_Z01 = "M1_Z01"
        M1_Z06 = "M1_Z06"
        M1_119 = "M1_119"
        M2_Z11 = "M2_Z11"
        M2_101 = "M2_101"
        M2_103 = "M2_103"
