# TalentSage
UI and API automation framework
Product Context:
TalentSage is an AI-Native Recruitment Operating System, helping HR teams and recruiters manage job postings, candidate submissions, and hiring workflows efficiently.

#Automated Tests:

1- UI Login Test:
1.1  Ensures that recruiters and users can securely log in with valid credentials and are blocked with invalid credentials.
1.2  Automating login validates a critical entry point to the platform and ensures that authentication is always working after updates, saving repetitive manual checks.

2- API Test (POST /posts or login API):
2.1  Validates backend services directly, including HTTP response codes, JSON structure, and required fields.
2.2 This ensures the data exchange between TalentSage frontend and backend is correct and reliable, which is crucial for AI-powered automation workflows like candidate scoring, job posting, and reporting.

Business Value:
Reduces human effort for repetitive critical checks
Provides early feedback during development and deployment
Increases confidence in core functionalities (login and API endpoints)

 #What Could Be Automated Next
 For TalentSage, additional areas to automate include:

UI Tests:

Job creation forms: Verify all fields, validations, and error messages
Candidate submission workflow: Ensure successful upload, scoring, and AI recommendations
Navigation & dashboard elements: Validate menus, filters, and report displays
Notifications & alerts: Confirm system-generated alerts and email notifications

API Tests:

Candidate endpoints: GET, POST, PUT, DELETE workflows
Job postings: Validate API responses for creating, updating, and deleting jobs
Analytics & reports endpoints: Ensure response structure and correctness
Integration with AI modules: Validate that candidate scoring and recommendation APIs return correct results
Automating these areas ensures high-risk, repeatable, and critical features are verified consistently across releases.

#What Should Remain Manual and Why

1- Exploratory testing:
Manual testing is essential to discover edge cases or unexpected user behavior that AI or automation cannot predict.
2- UI/UX evaluation:
Layout, responsiveness, and usability require human judgment to ensure TalentSage’s interface is intuitive and recruiter-friendly.
3- One-time or complex scenarios:
Rare workflows, unusual error handling, or special customer configurations are better suited for manual testing due to cost and effort required to automate.


For TalentSage, automation of login and API tests provides stability and reliability for core features, while manual testing focuses on human-centric evaluation, exploratory workflows, and UX validations. This approach balances efficiency, maintainability, and product quality, which aligns with evaluation criteria:

Code clarity: Automation code is structured and reusable
Assertion quality: Validates both success and failure conditions
Maintainability: Tests are modular and easy to update
Folder organization: UI and API tests are separated with clear resource structures
