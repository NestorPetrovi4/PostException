fun main() {
    val post = Post(1, 2, 3, date = 5, text = "test", replyOwnerId = 6, comments = Comments())
    WallService.add(post)
    WallService.add(post)
    WallService.add(post)
    val post1 = Post(2, 2, 3, date =  5, text =  "test update", replyOwnerId = 6,comments = Comments(), likes = Likes())
    WallService.update(post1)
    println(WallService.findPostId(3))
    println(WallService)
    val commentTest = Comment(1, 3, 20231206, "New comment", donut = Donut())
    WallService.createComment(3, commentTest)
}