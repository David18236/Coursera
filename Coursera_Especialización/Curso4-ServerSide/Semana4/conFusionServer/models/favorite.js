const mongoose = require('mongoose');
const Schema = mongoose.Schema;
require('mongoose-currency').loadType(mongoose);
const Currency = mongoose.Types.Currency;

var dishFavoriteSchema = new Schema({
    dishId: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Dish'
    }
}, {
    timestamps: true
});

const favoriteSchema = new Schema({

    user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User'
    },

    dishes: [ dishFavoriteSchema ]

}, {
    timestamps: true
});

var Favorites = mongoose.model('Favorite', favoriteSchema);

module.exports = Favorites;