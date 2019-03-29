
export default function Songs(songs) {
    return `
        <ul class="songs">
            ${songs.map(song => {
        return `
                    <li class="song">
                        <h4 class="song__songTitle" id="${song.id}">${song.songTitle}</h4>                      
                    </li>
                `
    }).join('')}
        </ul>
    `
}