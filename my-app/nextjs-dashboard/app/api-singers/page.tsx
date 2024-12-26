import { JSDOM } from 'jsdom';
export default async function Page(req, res) {
    const data = await fetch('http://127.0.0.1:8080/api/singers/all')
    const text = await data.text();


    return (
        <pre>{text}</pre>
    )
    return <p>Api-singers Page</p>;

}


