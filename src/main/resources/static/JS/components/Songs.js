import comments from './Comments'

export default function Songs(songs) {
    return `
        <ul class="songs">
            ${songs.map(song => {
                return `
                    <li class="song">
                        <h3 class="song__songTitle">${song.songTitle}</h3>
                        <p class="song__songLength">${song.duration}</p>
                        <p class="song__link"${song.link}></p>
                        <ul class="comments">
                            <li class="comment">${comments(song.comments)}</li>
                        </ul>
                    </li>
                `
            }).join('')}
    `
}