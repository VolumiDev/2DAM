const controladorFigura = {};
const figurasModels = require('../models/figura');

controladorFigura.mostrarFiguras = async (req, res) => {
    const figura = await figurasModels.find();
    res.json(figura);
};

module.export = controladorFigura;