Feature: Acceptance Criteria for getAdverts(sellerId): List<Advert>

Given I have a <valid sellerId with adverts>
And I request for Adverts
Then I must see list of adverts

Given I have a <sellerId without adverts>
And I request for Adverts
Then I must see an empty list

Given I have a <invalid/expired seller Id>
And I request for Adverts
Then an error must be thrown that the seller Id is Invalid


Feature: Acceptance Criteria for “canRepostForFree(sellerId): boolean”

Given I have <valid sellerId with adverts with permission to repost for free>
And request to repost for free
Then the boolean must return “true”

Given I have <valid sellerId with adverts with No permission to repost for free>
And request to repost for free
Then the boolean must return “false”

Given I have <valid sellerId with No adverts with permission to repost for free>
And request to repost for free
Then the boolean must return “false”

Given I have <valid sellerId with No adverts with No permission to repost for free>
And request to repost for free
Then the boolean must return “false”

Given I have <Invalid sellerId>
And request to repost for free
Then the boolean must return “false”


Feature: Acceptance Criteria for repostForFree(advertId): void

Given I have <advert with “repostForFree” permission >
And request to repost for free
Then the boolean must return “true”

Given I have <advert with No “repostForFree” permission >
And request to repost for free
Then the boolean must return “false”







