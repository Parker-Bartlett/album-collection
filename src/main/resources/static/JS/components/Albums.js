import songs from './Songs'

export default function Albums(albums) {
    return `
        <ul class="albums">
            ${albums.map(album => {
                return `
                    <li class="album">
                        <h3 class="album__albumTitle" id="${album.id}">${album.albumTitle}</h3>
                    </li>
                    `
                }).join('')}
        </ul>
    `
}
