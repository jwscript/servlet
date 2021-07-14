<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*
    jsp를 호출하면서 저장된 데이터를 조회 후, member 객체 정보를 화면에 다시 뿌려주는 방식. (너무 지저분...)
     */

    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            // ★ out은 예약어임 !! response.getWriter() 와 동일한 것이라고 생각하면 될 듯.
            out.write("<tr>\n");
            out.write(" <td>" + member.getId() + "</td>\n");
            out.write(" <td>" + member.getUsername() + "</td>\n");
            out.write(" <td>" + member.getAge() + "</td>\n");
            out.write("</tr>\n");
        }
    %>
    </tbody>
</table>
</body>
</html>