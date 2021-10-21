const controller = {};


controller.list = (req, res) => {
    req.getConnection((err, conn) => {
      conn.query('SELECT * FROM datos', (err, customers) => {
       if (err) {
        res.json(err);
       }

       res.render('customers', {
          data: customers
       });
      });
    });
};

controller.save = (req, res) => {
    const data = req.body;
    console.log(req.body)
    req.getConnection((err, connection) => {
      const query = connection.query('INSERT INTO datos set ?', data, (err, customer) => {
        console.log(customer)
        res.redirect('/');
      })
    })
};
  
controller.edit = (req, res) => {
    const { id } = req.params;
    req.getConnection((err, conn) => {
      conn.query("SELECT * FROM datos WHERE id_anime = ?", [id], (err, rows) => {
        res.render('customers_edit', {
          data: rows[0]
        })
      });
    });
};
  
controller.update = (req, res) => {
    const { id } = req.params;
    const newCustomer = req.body;
    req.getConnection((err, conn) => {
  
    conn.query('UPDATE datos set ? where id_anime = ?', [newCustomer, id], (err, rows) => {
      res.redirect('/');
    });
    });
};
  
controller.delete = (req, res) => {
    const { id } = req.params;
    req.getConnection((err, connection) => {
      connection.query('DELETE FROM datos WHERE id_anime = ?', [id], (err, rows) => {
        res.redirect('/');
      });
    });
}

module.exports = controller;