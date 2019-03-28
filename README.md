This is a small application created while learning Spring Framework and Hibernate. It has 3 access roles, Admin, MAC, Student.
Admin role can add/delete/update the programs_offered or programs_scheduled. Student apply for the programs and MAC will approve the applications he received.
Both student and MAC cannot apply and approve respectively in between application process start and after it ends.
Application approval is a 2 step procedure. If MAC approves an application, the next step is interview step and again MAC can either approve/reject.
Java Mail API is used for mailing. Student and MAC are shown applications according to the status.
