import java.lang.RuntimeException

data class Post(
    val id: Int,
    var ownerId: Int,
    var fromId: Int,
    var createdBy: Int = 0,
    var date: Int,
    var text: String,
    var replyOwnerId: Int,
    var friendsOnly: Boolean = false,
    var comments: Comments,
    var likes: Likes? = null,
    var attachments: Array<Attachments>? = null
)

class Comments(
    val count: Int = 0,
    var canPost: Boolean = true,
    var groupsCanPost: Boolean = true,
    var canClose: Boolean = true,
    var canOpen: Boolean = false
)

class Likes(
    val count: Int = 0,
    var userLikes: Boolean = false,
    var canLike: Boolean = true,
    var canPublish: Boolean = true
)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var lastId: Int = 0

    fun add(post: Post): Post {
        lastId += 1
        val newPost = post.copy(id = lastId)
        posts += newPost
        return newPost
    }

    fun update(post: Post): Boolean {
        for ((index, postReal) in posts.withIndex()) {
            if (postReal.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray<Post>()
        lastId = 0
        comments = emptyArray<Comment>()
    }

    fun findPostId(postId: Int): Boolean {
        for (post in posts) {
            if (post.id == postId) return true
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        if (!findPostId(postId)) {
            throw PostNotFoundException("не найден пост с id= $postId")
        }
        val newComment = comment.copy(id = comments.size + 1)
        comments += newComment
        return newComment
    }

    override fun toString(): String {
        return "WallService(posts=${posts.contentToString()})"
    }

}

class PostNotFoundException(message: String) : RuntimeException(message)

data class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    var text: String,
    val donut: Donut,
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Array<Attachments>? = null,
    val parentsStack: Array<Int>? = null,
    var thread: Thread? = null
)

class Donut(val isDon: Boolean = false, val placeholder: String = "")

class Thread(
    val count: Int,
    val items: Array<Comment>,
    val canPost: Boolean,
    val showReplyButton: Boolean,
    val groupsCanPost: Boolean
)
