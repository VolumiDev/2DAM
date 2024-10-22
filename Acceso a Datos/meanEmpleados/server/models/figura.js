const mongoose = require('mongoose');
const { Schema } = mongoose;

const figuraSchema = new Schema({
    nombre : {type: String, require: true},
    ejercito: {type: String, require: true},
    precio: {type: Number, require: true}
});

module.exports = mongoose.model('Figura', figuraSchema)