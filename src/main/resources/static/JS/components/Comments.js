export default function Comments(comments) {
    return comments
        .map(comment => {
            return `
            <ul>
                <li class="item">${comment.commentContent}</li>
            </ul>
            `
        }).join('')
}