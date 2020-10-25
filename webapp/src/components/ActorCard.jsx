import React from 'react';
import { Card, Col } from 'react-bootstrap';
import './ActorCard.css';

function ActorCard(props) {
    const { actor } = props;
    return (
        <Col sm={3}>
        <Card className="actorCard">
            <Card.Img variant="top" src={actor.imageUrl} />
            <Card.Body>
                <Card.Title>{actor.firstName + " " + actor.lastName}</Card.Title>
                <Card.Text>
                    <span className="cardTextRow" >Name: {actor.firstName + " " + actor.lastName}</span>
                    <span className="cardTextRow"> Date of birth: {actor.dateOfBirth}</span>
                    <span className="cardTextRow"><a href={actor.imdbUrl}> imdb</a> </span>
                </Card.Text>
            </Card.Body>
        </Card>
        </Col>
    );
}
export default ActorCard;
