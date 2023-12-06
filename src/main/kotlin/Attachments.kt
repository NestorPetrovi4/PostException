interface Attachments {
    val type: String
}

class PhotoAttachments(override val type: String = "photo", val photo: Photo) : Attachments

class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val sizes: Array<CopyPhoto>,
    val width: Int,
    val height: Int
)

class CopyPhoto(val type: String, val url: String, val width: Int, val height: Int)

class PostedPhotoAttachments(override val type: String = "posted_photo", val postedPhoto: PostedPhoto) : Attachments

class PostedPhoto(val id: Int, val ownerId: Int, val photo130: String, val photo604: String)

class VideoAttachments(override val type: String = "video", val video: Video) : Attachments

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<ImageVideo>,
    val firstFrame: Array<FirstFrame>,
    val date: Int,
    val addingDate: Int,
    var views: Int,
    var localViews: Int,
    var comments: Int,
    val player: String,
    val platform: String,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val isFavorite: Boolean,
    val canComment: Boolean,
    val canEdit: Boolean,
    val canLike: Boolean,
    val canRepost: Boolean,
    val canSubscribe: Boolean,
    val canAddToFaves: Boolean,
    val canAttachLink: Boolean,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting: Boolean,
    val added: Boolean,
    val isSubscribed: Boolean,
    val repeat: Int,
    val type: String,
    var balance: Int,
    var liveStatus: String,
    val live: Boolean,
    var upcoming: Int,
    var spectators: Int,
    val likes: LikesVideo,
    val reposts: RepostVideo

)

class RepostVideo(val count: Int, val wallCount: Int, val mailCount: Int, val userReposted: Int)

class LikesVideo(val count: Int, var userLikes: Boolean)

class FirstFrame(val height: Int, val url: String, val width: Int)

class ImageVideo(val height: Int, val url: String, val width: Int, val withPadding: Int)

class GraffitiAttachments(override val type: String = "graffiti", val graffiti: Graffiti) : Attachments

class Graffiti(val id: Int, val ownerId: Int, val photo130: String, val photo604: String)

class EventAttachments(override val type: String = "event", val eventPost: EventPost) : Attachments

class EventPost(
    val id: Int,
    val time: Int,
    var memberStatus: Int,
    var isFavorite: Boolean,
    var address: String,
    var text: String,
    var buttonText: String,
    var friends: Array<Int>
)

class AlbumAttachments(override val type: String = "album", val album: Album) : Attachments

class Album(
    val id: Int,
    val thumb: Photo,
    val ownerId: Int,
    val title: String,
    val description: String,
    val created: Int,
    var updated: Int,
    var size: Int
)
