import React, { useEffect } from "react";
import styled from "styled-components";
import axios from "axios";

const GridWrapper = styled.div`
  margin-left: 75px;
  color: white;
  background-color: #454545;
  height: 92%;

  table {
    width: 100%;
    height: 100%;
  }

  textarea {
    background-color: #333;
    color: white;
    width: 100%;
    height: 100%;
    margin: 0;
    resize: none;
    outline: none;
    border: none;
  }

  form {
    height: 100%;
  }

  input {
    margin-top: 0;
    height: 10%;
    width: 100%;
    background-color: #3a3a3a;
    color: white;
    font-size: 150%;
    border: none;
    outline: none;

    &:hover {
      background-color: #313131;
    }
    &:active {
      background-color: #222;
    }
  }

  .title {
    height: 7%;
  }

  .codeArea {
    height: 73%;
    padding: 0;
  }

  .textArea {
    height: 89%;
  }

  .output {
    height: 20%;
    margin-top: 0;
    padding-top: 1em;
    background-color: #343434;
    color: white;
    vertical-align: top;
  }

  .outputText {
    height: 100%;
  }
`;

export default class Terminal extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: "Text editing? No.\nProgramming? Yes.",
      out: "Press run to run code.",
    };

    this.handleUnload = this.handleUnload.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.sendCode = this.sendCode.bind(this);
  }

  async sendCode(event) {
    event.preventDefault();

    const response = await axios.post(
      "http://localhost:8080/api/terminal",
      {
        code: this.state.value,
      },
      {
        headers: {
          key: "1636048388043287093",
        },
      }
    );
    this.setState({ out: response.data });
    console.log(response.data);
  }

  componentDidMount() {
    window.addEventListener("beforeunload", this.handleUnload);
  }

  componentWillUnmount() {
    window.removeEventListener("beforeunload", this.handleUnload);
  }

  handleChange(event) {
    this.setState({ value: event.target.value });
  }

  handleUnload(event) {
    let message = "Do you want to leave?\n(Unsaved content)";
    (event || window.event).returnValue = message;
    return message;
  }

  render() {
    return (
      <GridWrapper>
        <table>
          <tr className="title">
            <td>
              <h2>Python Terminal</h2>
            </td>
          </tr>
          <tr className="codeArea">
            <td>
              <form onSubmit={this.sendCode}>
                <textarea
                  className="textArea"
                  value={this.state.value}
                  onChange={this.handleChange}
                />

                <input className="submit" type="submit" value="Run" />
              </form>
            </td>
          </tr>
          <tr className="output" id="out">
            <td>
              <textarea
                readOnly
                className="outputText"
                resize="none"
                value={this.state.out}
              />
            </td>
          </tr>
        </table>
      </GridWrapper>
    );
  }
}
