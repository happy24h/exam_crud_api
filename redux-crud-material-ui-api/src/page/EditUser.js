import { useState, useEffect } from "react";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";
import { useParams, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { editUser, listUsers } from "../redux/actions";

function EditUser() {
  const [state, setState] = useState({
    id: "",
    name: "",
    price: "",
    quantity: "",
  });

  let { users } = useSelector((state) => state.data);

  let dispatch = useDispatch();

  let history = useNavigate();

  let { id } = useParams();
  const filterUser = users.filter((item) => item.id === +id);
  console.log("check filter ====>", filterUser[0]);

  useEffect(() => {
    dispatch(listUsers);
    if (filterUser[0]) {
      setState(filterUser[0]);
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [id]);

  console.log("check id", id);
  const handleEdit = () => {
    if (!name || !price || !quantity) {
      alert("Vui lòng nhập đầy đủ thông tin !");
    } else {
      dispatch(editUser(state));
      history("/");
    }
  };
  const handleInputChange = (e) => {
    let { name, value } = e.target;
    setState({ ...state, [name]: value, id: id });
  };
  let { name, price, quantity } = state;

  console.log("check state:", state);
  return (
    <Box sx={{ my: 18 }}>
      <Link to="/" style={{ textDecoration: "none" }}>
        <Button variant="contained" color="secondary">
          Back
        </Button>
      </Link>

      <Box
        component="form"
        sx={{
          "& > :not(style)": { m: 1, width: "45ch" },
        }}>
        <TextField
          value={name}
          name="name"
          id="standard-basic"
          label="Name"
          variant="standard"
          onChange={(e) => handleInputChange(e)}
        />
        <br />
        <TextField
          value={price}
          name="price"
          id="standard-basic"
          label="price"
          variant="standard"
          onChange={(e) => handleInputChange(e)}
        />{" "}
        <br />
        <TextField
          value={quantity}
          name="quantity"
          id="standard-basic"
          label="quantity"
          variant="standard"
          onChange={(e) => handleInputChange(e)}
        />{" "}
      </Box>
      <Button
        sx={{ my: 2 }}
        variant="contained"
        type="submit"
        onClick={() => handleEdit()}>
        Update
      </Button>
    </Box>
  );
}

export default EditUser;
