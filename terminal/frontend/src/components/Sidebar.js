import React from "react";
import styled from "styled-components";
import { Link, withRouter } from "react-router-dom";

const StyledSideNav = styled.div`
  position: fixed; /* Fixed Sidebar (stay in place on scroll and position relative to viewport) */
  height: 100%;
  width: 75px;
  z-index: 1;
  top: 3.4em;
  background-color: #222;
  overflow-x: hidden;
  padding-top: 10px;
`;

class SideNav extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activePath: props.location.pathname,
      items: [
        {
          path: "/",
          name: "Home",
          css: "fa fa-fw fa-home",
          key: 1,
        },
        {
          path: "/terminal",
          name: "Terminal",
          css: "fas fa-terminal",
          key: 2,
        },
        // {
        //   path: "/about",
        //   name: "About",
        //   css: "fa fa-fw fa-clock",
        //   key: 3,
        // },
      ],
    };
  }

  onItemClick = (path) => {
    this.setState({ activePath: path });
  };

  render() {
    const { items, activePath } = this.state;
    return (
      <StyledSideNav>
        {items.map((item) => {
          return (
            <NavItem
              path={item.path}
              name={item.name}
              css={item.css}
              onItemClick={this.onItemClick}
              active={item.path === activePath}
              key={item.key}
            />
          );
        })}
      </StyledSideNav>
    );
  }
}

const RouterSideNav = withRouter(SideNav);

const StyledNavItem = styled.div`
  height: 70px;
  width: 75px;
  text-align: center;
  margin-bottom: 0;

  a {
    font-size: 2.7em;
    color: ${(props) => (props.active ? "white" : "#ff792b")};
    :hover {
      opacity: 0.7;
      text-decoration: none;
    }
  }
`;

class NavItem extends React.Component {
  handleClick = () => {
    const { path, onItemClick } = this.props;
    onItemClick(path);
  };

  render() {
    const { active } = this.props;

    return (
      <StyledNavItem active={active}>
        <Link
          to={this.props.path}
          className={this.props.css}
          onClick={this.handleClick}
        >
          <NavIcon></NavIcon>
        </Link>
      </StyledNavItem>
    );
  }
}

const NavIcon = styled.div``;

export default class Sidebar extends React.Component {
  render() {
    return <RouterSideNav></RouterSideNav>;
  }
}
