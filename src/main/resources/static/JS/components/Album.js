import Songs from './Songs'

export default function Album(album) {
    return `
        <h3 class="album__albumTitle">${album.albumTitle}</h3>
        <p class="album__image">${album.image}</p>
        <p class="album__recordLabel">${album.recordLabel}</p>
 
        <ul class="songs">
            <li class="song">${Songs(album.songs)}</li>
        </ul>
            `
}