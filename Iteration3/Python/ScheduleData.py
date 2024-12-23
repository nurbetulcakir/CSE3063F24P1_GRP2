from enum import Enum

class ScheduleData:

    class Day(Enum):
        MONDAY = "Monday"
        TUESDAY = "Tuesday"
        WEDNESDAY = "Wednesday"
        THURSDAY = "Thursday"
        FRIDAY = "Friday"

    class StartTime(Enum):
        _08_30 = "08:30"
        _09_30 = "09:30"
        _10_30 = "10:30"
        _11_30 = "11:30"
        _13_00 = "13:00"
        _14_00 = "14:00"
        _15_00 = "15:00"
        _16_00 = "16:00"

    class EndTime(Enum):
        _09_20 = "09:20"
        _10_20 = "10:20"
        _11_20 = "11:20"
        _12_20 = "12:20"
        _13_50 = "13:50"
        _14_50 = "14:50"
        _15_50 = "15:50"
        _16_50 = "16:50"

    class Classroom(Enum):
        M1_Z01 = "M1_Z01"
        M1_Z06 = "M1_Z06"
        M1_119 = "M1_119"
        M2_Z11 = "M2_Z11"
        M2_101 = "M2_101"
        M2_103 = "M2_103"
