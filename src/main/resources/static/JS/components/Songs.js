
export default function Songs(songs) {
    return `
        <ul class="songs">
            ${songs.map(song => {
        return `
                    <li class="song">
                        <h3 class="song__songTitle">${song.songTitle}</h3>                      
                    </li>
                `
    }).join('')}
        </ul>
    `
}