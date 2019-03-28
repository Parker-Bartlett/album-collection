export default function Comments(comments) {
    return comments
        .map(comment => {
            return `
            <ul>
                <li>${comment.commentContent}</li>
            </ul>
            `
        }).join('')
}