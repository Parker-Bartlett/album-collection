export default function Artists(artists) {
    return `
        <ul class="artists">
            ${artists.map(artist => {
                return `
                    <li class="artist">
                        <h3 class="artist__artistName">${artist.artistName}</h3>                     
                    </li>
                    `
            }).join('')}
        </ul>
        <section class="add__artist">
            <input type="text" class="add__artistName" placeholder="Artist Name">
            <input type="text" class="add__image" placeholder="Image URL">
            <button class="add__artist__button">Add Artist</button>
        </section>
       `
}