class Scheduler:

    @staticmethod
    def detect_conflict(schedule):

        conflicts = []
        for i in range(len(schedule)):
            for j in range(i + 1, len(schedule)):
                session1 = schedule[i]
                session2 = schedule[j]
                # Check for same day and overlapping times
                if (session1["day"] == session2["day"] and
                        session1["start_time"] < session2["end_time"] and
                        session1["end_time"] > session2["start_time"]):
                    conflicts.append({
                        "session1": session1,
                        "session2": session2
                    })
        return conflicts

    @staticmethod
    def has_conflicts(schedule):

        return len(Scheduler.detect_conflict(schedule)) > 0
