@SmokeTest
Feature: basic smoke test
  Test high scenarios for reddit subreddit account



	@Scenario1
	Scenario: Log into my account , go to my subreddit and leave a comment
		Given I want to launch reddit
			And I log into my account
		When I go to my subreddits
			And I check that the thread "Online secure document collaboration" 
			And I add comment on the post "TESTING" with my name "Peter Doe"
			And I click down vote in latest comment
			And I click up vote in latest comment
		Then I check page title is "TESTING"
			And I want print the report

		

		
		
