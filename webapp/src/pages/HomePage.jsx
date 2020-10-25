import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ActorCard from '../components/ActorCard';
import { Container, Row } from 'react-bootstrap';

function HomePage(props) {

    const [actors, setActors] = useState([]);

    function getAllActors() {
        axios.get("/api/actor/all").then(response => setActors(response.data.object));
    };

    useEffect(() => {
        getAllActors();
    }, []);

    const allActorsCards = actors.map((actor, index) => (
        <ActorCard key={index} actor={actor}></ActorCard>
    ));

    return (
        <Container className="justify-content-center">
            <Row>{allActorsCards}</Row>
        </Container>
    );
}
export default HomePage;