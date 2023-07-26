Feature: Testing different requests on the Photo application

Scenario Outline:  Update an entire photo resource, verify the response status code and response body
When I fully update a photo enrollment with following values PhotoId <photoId> AlbumId <albumId>,Title <title>url <url>,ThumbnailUrl <thumbnailUrl>
Then I must receive a positive confirmation about the photo enrollment successful updated

Examples:
| photoId | albumId | title | url | thumbnailUrl |
| 2554 | 201 | "First Photo" | "http://example.com/photo1.jpg"| "http://example.com/thumb1.jpg" |