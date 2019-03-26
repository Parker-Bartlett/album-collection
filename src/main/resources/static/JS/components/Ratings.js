export default function Ratings(ratings) {
    return `
        <h3>${averageRating(ratings)}</h3>
         `
}

function averageRating(ratings) {
    console.log(ratings)
    let count = 0
    for (let i = 0; i < ratings.length; i++) {
        count += ratings[i].albumRating
    }
    return (count / ratings.length)
}