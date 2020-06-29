import React, { Component } from 'react';
import { Card, CardImg, CardImgOverlay, CardText, CardBody, CardTitle } from 'reactstrap';

class DishDetail extends Component {
    constructor(props) {
        super(props);
    }

    renderComments(comments) {

        if (comments != null) {
            let comentarioschaval = comments.map((comm) => {
                return (
                    <li key={comm.id}>
                        <p> {comm.comment} </p>
                        <p> -- {comm.author}, {comm.date} </p>
                    </li>
                );
            });
            
            return (
                <div className="col-12 col-sm-5">
                    <h4> <strong> Comments </strong> </h4>

                    <ul className="list-unstyled">
                        {comentarioschaval}
                    </ul>
                </div>
            );

        }

        else {
            return (<div></div>);
        }
    }

    renderDish(dish) {
        return (
            <div className="row">
                <div className="col-12 col-sm-5">
                    <Card>
                        <CardImg width="100%" src={dish.image} alt={dish.name} />

                        <CardBody>
                            <CardTitle> {dish.name} </CardTitle>
                            <CardText> {dish.description} </CardText>
                        </CardBody>
                    </Card>
                </div>

                {this.renderComments(dish.comments)}
            </div>
        );
    }

    render() {
        const dish = this.props.dish;

        if (dish != null) {
            return (
                this.renderDish(dish)
            );
        }

        else {
            return (<div></div>);
        }
    }
}

export default DishDetail;