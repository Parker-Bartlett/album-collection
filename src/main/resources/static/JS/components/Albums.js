import songs from './Songs'

export default function Albums(albums) {
    return `
        <ul class="albums">
            ${albums.map(album => {
                return `
                    <li class="album">
                        <h3 class="album__albumTitle">${album.albumTitle}</h3>
                        <p class="album__image">${album.image}</p>
                        <p class="album__recordLabel">${album.recordLabel}</p>
                        // move list of songs to somewhere else. the rest should stay here on album page
                        <ul class="songs">
                            <li class="song">${songs(album.songs)}</li>
                        </ul>
                    </li>
                    `
                }).join('')}
        </ul>
    `
}
