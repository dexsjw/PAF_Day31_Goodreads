export interface Book {
    bookId: string,
    title: string,
    authors: string,
    description: string,
    edition?: string,
    format?: string,
    pages: number,
    rating: number,
    ratingCount: number,
    reviewCount: number,
    genres: string,
    imageUrl: string
}