import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(0, 2, 3, date = 5, text = "test", replyOwnerId = 6, comments = Comments(), likes = Likes())
        val newPost = WallService.add(post)
        assertEquals(newPost.id, 1)
    }

    @Test
    fun updateRealPost() {
        WallService.add(
            Post(
                0,
                2,
                3,
                date = 5,
                text = "test",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        WallService.add(
            Post(
                0,
                3,
                3,
                date = 5,
                text = "test_1",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        val result = WallService.update(
            Post(
                2,
                3,
                3,
                date = 5,
                text = "test_______________",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        assertEquals(result, true)
    }

    @Test
    fun updateFalsePost() {
        WallService.add(
            Post(
                0,
                2,
                3,
                date = 5,
                text = "test",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        WallService.add(
            Post(
                0,
                3,
                3,
                date = 5,
                text = "test_1",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        val result = WallService.update(
            Post(
                -1,
                3,
                3,
                date = 5,
                text = "test_______________",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        assertEquals(result, false)
    }

    @Test
    fun addCommentForRealPost() {
        WallService.add(
            Post(
                0,
                2,
                3,
                date = 5,
                text = "test",
                replyOwnerId = 6,
                comments = Comments(),
                likes = Likes()
            )
        )
        val commentTest = Comment(0, 3, 20231206, "New comment", donut = Donut())
        val comment = WallService.createComment(1, commentTest)
        assertEquals((comment.id == commentTest.id), false)
    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentForNotPost() {
        val commentTest = Comment(0, 3, 20231206, "New comment", donut = Donut())
        val comment = WallService.createComment(1, commentTest)
    }
}